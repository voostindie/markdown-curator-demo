---
extensions:
    project:
        folder: Projects
    journal:
        folder: Journal
        markers-folder: Markers
        activities-section: Activities
        projects-folder: Projects
    projectjournal:
    alfred:
        projects-path: Projects
---
This note enables and configures the extensions used by the [[Markdown Curator]] that is monitoring this vault. The curator is completely dynamic: change the configuration here, wait a few seconds, and watch the new configuration become active. No restarts required.

Here's the list of available extensions and their current status:

<!--query:extensions-->
- 🟢 **alfred**: Exposes curator settings and external links to the Alfred workflow.
    - requires: Journal
    - settings: contacts-path, links-section, projects-path, reminders-path, systems-path, teams-path, third-parties-path
- 🟢 **journal**: Journal extracted from daily notes, with markers, timelines and navigation.
    - provides: Journal
    - settings: activities-section, folder, markers-folder, projects-folder
- ⚪️ **omnifocus**: Compares projects in the vault with projects in OmniFocus.
    - requires: ProjectRepository
    - settings: exclude, exclude-prefixes, folder
- 🟢 **project**: Projects, one document per project, with pluggable attributes.
    - provides: ProjectAttributeRepository, ProjectRepository
    - settings: folder
- 🟢 **projectjournal**: Resolves the lead, status and last modification date of projects from the journal.
    - requires: Journal, ProjectRepository
<!--/query (8701dd32)-->

Legend:

- 🟢: the extension is enabled and configured correctly. All good!
- 🔴: the extension is enabled but not configured correctly. Check the errors and fix them in the front matter of this file!
- ⚪️: the extension is not enabled and not doing anything.

If you have OmniFocus installed, then you can also enable the `omnifocus` extension to have the project priorities and OmniFocus URLs resolved from there. Make sure to set up a folder in OmniFocus that holds your demo projects, and then configure that name for the extension here.

