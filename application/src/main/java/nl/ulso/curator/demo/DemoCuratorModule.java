package nl.ulso.curator.demo;

import dagger.Module;
import dagger.Provides;
import jakarta.inject.Named;
import nl.ulso.curator.CuratorModule;
import nl.ulso.curator.addon.journal.JournalSettings;
import nl.ulso.curator.addon.omnifocus.OmniFocusModule;
import nl.ulso.curator.addon.omnifocus.OmniFocusSettings;
import nl.ulso.curator.addon.project.ProjectSettings;
import nl.ulso.curator.addon.projectjournal.ProjectJournalModule;
import org.slf4j.Logger;

import java.nio.file.InvalidPathException;
import java.nio.file.Path;

import static nl.ulso.curator.CuratorModule.WATCH_DOCUMENT_KEY;
import static org.slf4j.LoggerFactory.getLogger;

/// Main module for the demo curator.
///
/// Every curator includes at least the [CuratorModule]. That module requires a [Path] to be
/// provided: the path to the vault on disk. With just that, the curator works. The amount of
/// queries provided is limited, however.
///
/// By including the [ProjectJournalModule], this module needs to provide a [ProjectSettings] and a
/// [JournalSettings].
///
/// If you have OmniFocus installed, you can include the [OmniFocusModule] too. Make sure it has a
/// folder called `Demo` to begin with.
///
/// All the other methods in this curator are only present to correctly read the path to the vault
/// from the environment.
@Module(includes = {
    CuratorModule.class,
    //    OmniFocusModule.class,
    ProjectJournalModule.class
})
abstract class DemoCuratorModule
{
    private static final Logger LOGGER = getLogger(DemoCuratorModule.class);

    private static final String VAULT_PATH_ENVIRONMENT_VARIABLE = "VAULT_PATH";
    private static final String WATCH_DOCUMENT = "WATCHDOC";
    private static final String JOURNAL_FOLDER = "Journal";
    private static final String ACTIVITIES_SECTION = "Activities";
    private static final String MARKER_SUB_FOLDER = "Markers";
    private static final String PROJECT_FOLDER = "Projects";
    private static final String OMNIFOCUS_FOLDER = "Demo";

    @Provides
    static Path vaultPath()
    {
        var pathAsString = resolveVaultPathFromEnvironmentVariable();
        var vaultPath = parseVaultPathString(pathAsString);
        validateVaultPath(vaultPath);
        return vaultPath;
    }

    @Provides
    @Named(WATCH_DOCUMENT_KEY)
    static String watchDocument()
    {
        return WATCH_DOCUMENT;
    }

    @Provides
    static ProjectSettings projectSettings()
    {
        return new ProjectSettings(PROJECT_FOLDER);
    }

    @Provides
    static JournalSettings journalSettings()
    {
        return new JournalSettings(
            JOURNAL_FOLDER,
            MARKER_SUB_FOLDER,
            ACTIVITIES_SECTION,
            PROJECT_FOLDER
        );
    }

    @Provides
    static OmniFocusSettings omniFocusSettings()
    {
        return new OmniFocusSettings(OMNIFOCUS_FOLDER);
    }

    private static String resolveVaultPathFromEnvironmentVariable()
    {
        var pathAsString = System.getenv(VAULT_PATH_ENVIRONMENT_VARIABLE);
        if (pathAsString == null)
        {
            LOGGER.error(
                "Environment variable {} is missing; it must point to the vault directory",
                VAULT_PATH_ENVIRONMENT_VARIABLE
            );
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
            LOGGER.error(
                "Environment variable {} doesn't refer to a valid path: {}",
                VAULT_PATH_ENVIRONMENT_VARIABLE,
                pathAsString
            );
            throw new RuntimeException(e);
        }
        return vaultPath;
    }

    private static void validateVaultPath(Path vaultPath)
    {
        var file = vaultPath.toFile();
        if (!file.exists() || !file.isDirectory())
        {
            LOGGER.error(
                "Environment variable {} doesn't refer to a directory: {}",
                VAULT_PATH_ENVIRONMENT_VARIABLE,
                vaultPath
            );
            throw new RuntimeException();
        }
    }
}
