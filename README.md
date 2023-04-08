# Introduction

This repository contains a demo vault and accompanying application. Its purpose is twofold:

1. Showcase the [markdown-curator](https://github.com/voostindie/markdown-curator) framework.
2. Serve as a starting point for live demos on how I keep notes.

## Prerequisites

To be able to compile the [code in this project](application/), you need 3 things:

1. An OpenJDK 20+ installation (I use [Azul Zulu](https://www.azul.com/downloads/?package=jdk))
2. [Apache Maven](https://maven.apache.org) 3.9+
3. A local install of a snapshot of <https://github.com/voostindie/markdown-curator>

Regarding point 3: this is needed because I have not yet published a release of the `markdown-curator` in Maven Central. Until then: clone the project and run a `mvn install`. That should do it.

## Running the curator

Executing `run.sh` compiles, packages and runs the curator. It will then start watching the demo vault and do its magic.

## About the demo curator

The demo curator is extremely simple. All code is in a single class: [DemoCuratorModule](application/src/main/java/nl/ulso/markdown_curator/demo/DemoCuratorModule.java). This class:

- Reads the environment variable `VAULT_PATH` and uses that as the path of the vault to monitor.
- Extends the base `CuratorModule` by installing the `JournalModule`, as used in the demo vault.
