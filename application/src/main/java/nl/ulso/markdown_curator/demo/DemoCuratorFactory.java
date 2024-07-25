package nl.ulso.markdown_curator.demo;

import nl.ulso.markdown_curator.Curator;
import nl.ulso.markdown_curator.CuratorFactory;

/**
 * This factory is the bridge to the curator application: by implementing the {@link CuratorFactory}
 * interface and registering this interface in the
 * {@literal META-INF/services/nl.ulso.markdown_curator.CuratorFactory}, the main application can
 * automatically detect and use it.
 * <p/>
 * The implementation uses a Dagger-generated factory to create a {@link DemoCurator} instance
 * and have it create the {@link Curator}, with all dependencies injected correctly at build-time.
 */
public class DemoCuratorFactory implements CuratorFactory
{
    private static final String VAULT_NAME = "Demo";

    @Override
    public String name()
    {
        return VAULT_NAME;
    }

    @Override
    public Curator createCurator()
    {
        return DaggerDemoCurator.create().curator();
    }
}
