import com.google.cloud.bigquery._
import com.google.cloud.bigquery.BigQuery._

object Main extends App {

  val bigquery = BigQueryOptions.getDefaultInstance().getService()

  val queryConfig = QueryJobConfiguration.of("SELECT * FROM mochi_test.hoge where id = 2")
  val queryResponse = bigquery.query(
    queryConfig,
    QueryOption.of(QueryResultsOption.maxWaitTime(60000L)),
    QueryOption.of(QueryResultsOption.pageSize(1000L)))
  val rs = queryResponse.getResult()
  println(if (rs.getValues.iterator().next().get("status").getBooleanValue) "True" else "False")
}
