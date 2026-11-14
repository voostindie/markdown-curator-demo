package nl.ulso.curator.demo;

import dagger.Module;
import dagger.Provides;
import jakarta.inject.Named;
import nl.ulso.curator.CuratorModule;
import org.slf4j.Logger;

import java.nio.file.InvalidPathException;
import java.nio.file.Path;

import static nl.ulso.curator.CuratorModule.CONFIGURATION_DOCUMENT_KEY;
import static nl.ulso.curator.CuratorModule.WATCH_DOCUMENT_KEY;
import static org.slf4j.LoggerFactory.getLogger;

/// Main module for the demo curator.
///
/// Every curator includes at least the [CuratorModule]. That module requires a [Path] to be
/// provided: the path to the vault on disk. With just that, the curator works. The number of
/// queries provided is limited, however.
///
/// By including several extensions, the curator becomes more powerful, offering more services.
/// Extensions must be enabled and (optionally) configured before they are active. This is done by
/// providing a configuration document in the vault, with a front-matter configuration.
@Module(includes = {CuratorModule.class})
abstract class DemoCuratorModule
{
    private static final Logger LOGGER = getLogger(DemoCuratorModule.class);

    private static final String VAULT_PATH_ENVIRONMENT_VARIABLE = "VAULT_PATH";
    private static final String WATCH_DOCUMENT = "WATCHDOC";
    private static final String CONFIG_DOCUMENT = "CONFIG";

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
    @Named(CONFIGURATION_DOCUMENT_KEY)
    static String configDocument()
    {
        return CONFIG_DOCUMENT;
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
