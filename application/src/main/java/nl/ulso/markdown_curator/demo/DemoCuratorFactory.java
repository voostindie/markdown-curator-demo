package nl.ulso.markdown_curator.demo;

import nl.ulso.markdown_curator.Curator;
import nl.ulso.markdown_curator.CuratorFactory;

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
