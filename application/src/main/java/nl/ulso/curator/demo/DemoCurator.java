package nl.ulso.curator.demo;

import dagger.Component;
import jakarta.inject.Singleton;
import nl.ulso.curator.Curator;

/// This is the main Dagger component for the curator; every curator implementation has one, and
/// they are all as simple as this one: the component builds on top of the [DemoCuratorModule]
/// and offers a single method to pull the [Curator] out of it.
@Singleton
@Component(modules = DemoCuratorModule.class)
interface DemoCurator
{
    Curator curator();
}
