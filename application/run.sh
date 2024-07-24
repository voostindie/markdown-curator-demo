cd "$(dirname $0)" || exit
echo "Compiling and packaging demo curator"
mvn -q -B package
echo "Running demo Markdown curator"
VAULT_PATH=`cd ../vault; pwd` java -Xmx128m -jar target/markdown-curator-demo-1.0-SNAPSHOT.jar
