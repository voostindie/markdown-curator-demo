package nl.ulso.markdown_curator.demo;

import dagger.Component;
import nl.ulso.markdown_curator.Curator;

import javax.inject.Singleton;

/**
 * This is the main Dagger component for the curator; every curator implementation has one, and
 * they are all as simple as this one: the component builds on top of the {@link DemoCuratorModule}
 * and offers a single method to pull the {@link Curator} out of it.
 **/
@Singleton
@Component(modules = DemoCuratorModule.class)
interface DemoCurator
{
    Curator curator();
}
