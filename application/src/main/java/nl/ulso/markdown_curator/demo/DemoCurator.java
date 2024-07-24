package nl.ulso.markdown_curator.demo;

import dagger.Component;
import nl.ulso.markdown_curator.Curator;

import javax.inject.Singleton;

@Singleton
@Component(modules = DemoCuratorModule.class)
interface DemoCurator
{
    Curator curator();
}
