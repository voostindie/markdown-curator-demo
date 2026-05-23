Change this note to have the Markdown Curator reset its internal state completely and rerun all the queries. That’s the only purpose this note has.

The process to detect bugs in the curator is as follows:

- First commit all changes in the vault to version control.
- Then change this note. (Just `touch` it.)
- Check which notes were updated. There should be zero.

If any notes were updated, then these were somehow missed by the curator during normal operations. That implies a bug in the code.

