package nl.ulso.curator.demo;

import nl.ulso.curator.*;

/// This factory is the bridge to the curator application: by implementing the [CuratorFactory]
/// interface and registering this interface in the
/// `META-INF/services/nl.ulso.curator.CuratorFactory` file, the main application can automatically
/// detect and use it.
///
/// The implementation uses a Dagger-generated factory to create a [DemoCurator] instance and have
/// it create the [Curator], with all dependencies injected correctly at build-time.
public class DemoCuratorFactory
    implements CuratorFactory
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
