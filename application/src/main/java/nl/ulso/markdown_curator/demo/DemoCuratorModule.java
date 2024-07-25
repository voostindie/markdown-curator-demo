package nl.ulso.markdown_curator.demo;

import dagger.Module;
import dagger.Provides;
import nl.ulso.markdown_curator.CuratorModule;
import nl.ulso.markdown_curator.journal.JournalModule;
import nl.ulso.markdown_curator.journal.JournalSettings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.InvalidPathException;
import java.nio.file.Path;

/**
 * Main module for the demo curator.
 * <p/>
 * Every curator includes at least the {@link CuratorModule}. That module requires a {@link Path}
 * to be provided: the path to the vault on disk. With just that, the curator works. The amount
 * of queries provided is limited however.
 * <p/>
 * By including the {@link JournalModule} also, this module needs to provide a
 * {@link JournalSettings} also, to configure the journal.
 * <p/>
 * All the other methods in this curator are only present to correctly read the path to the vault
 * from the environment.
 */
@Module(includes = {CuratorModule.class, JournalModule.class})
abstract class DemoCuratorModule
{
    private static final Logger LOGGER = LoggerFactory.getLogger(DemoCuratorModule.class);

    private static final String VAULT_PATH_ENVIRONMENT_VARIABLE = "VAULT_PATH";
    private static final String JOURNAL_FOLDER = "Journal";
    private static final String ACTIVITIES_SECTION = "Activities";
    private static final String MARKER_SUB_FOLDER = "Markers";
    private static final String PROJECT_FOLDER = "Projects";

    @Provides
    static Path vaultPath()
    {
        var pathAsString = resolveVaultPathFromEnvironmentVariable();
        var vaultPath = parseVaultPathString(pathAsString);
        validateVaultPath(vaultPath);
        return vaultPath;
    }

    @Provides
    static JournalSettings journalSettings()
    {
        return new JournalSettings(JOURNAL_FOLDER, MARKER_SUB_FOLDER, ACTIVITIES_SECTION,
                PROJECT_FOLDER);
    }

    private static String resolveVaultPathFromEnvironmentVariable()
    {
        var pathAsString = System.getenv(VAULT_PATH_ENVIRONMENT_VARIABLE);
        if (pathAsString == null)
        {
            LOGGER.error(
                    "Environment variable {} is missing; it must point to the vault directory",
                    VAULT_PATH_ENVIRONMENT_VARIABLE);
            throw new RuntimeException();
        }
        return pathAsString;
    }

    private static Path parseVaultPathString(String pathAsString)
    {
        Path vaultPath;
        try
        {
            vaultPath = Path.of(pathAsString).toAbsolutePath();
        }
        catch (InvalidPathException e)
        {
            LOGGER.error("Environment variable {} doesn't refer to a valid path: {}",
                    VAULT_PATH_ENVIRONMENT_VARIABLE, pathAsString);
            throw new RuntimeException(e);
        }
        return vaultPath;
    }

    private static void validateVaultPath(Path vaultPath)
    {
        var file = vaultPath.toFile();
        if (!file.exists() || !file.isDirectory())
        {
            LOGGER.error("Environment variable {} doesn't refer to a directory: {}",
                    VAULT_PATH_ENVIRONMENT_VARIABLE, vaultPath);
            throw new RuntimeException();
        }
    }
}
