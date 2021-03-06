import filters.ExampleProjectFilters
import org.coursera.naptime.NaptimeModule
import org.coursera.naptime.ari.FetcherApi
import org.coursera.naptime.ari.LocalSchemaProvider
import org.coursera.naptime.ari.SchemaProvider
import org.coursera.naptime.ari.fetcher.LocalFetcher
import org.coursera.naptime.ari.graphql.DefaultGraphqlSchemaProvider
import org.coursera.naptime.ari.graphql.GraphqlSchemaProvider
import org.coursera.naptime.ari.graphql.controllers.filters.ComplexityFilterConfiguration
import org.coursera.naptime.ari.graphql.controllers.filters.FilterList
import org.coursera.naptime.ari.graphql.controllers.middleware.GraphQLMetricsCollector
import org.coursera.naptime.ari.graphql.controllers.middleware.LoggingMetricsCollector
import resources.UserStore
import resources.UserStoreImpl
import resources.UsersResource
import resources.CoursesResource
import resources.InstructorsResource
import resources.PartnersResource


class ResourceModule extends NaptimeModule {
  override def configure(): Unit = {
    bindResource[UsersResource]
    bindResource[CoursesResource]
    bindResource[InstructorsResource]
    bindResource[PartnersResource]
    bind[UserStore].to[UserStoreImpl]
    bind[FetcherApi].to[LocalFetcher]
    bind[GraphQLMetricsCollector].to[LoggingMetricsCollector]
    bind[SchemaProvider].to[LocalSchemaProvider]
    bind[GraphqlSchemaProvider].to[DefaultGraphqlSchemaProvider]
    bind[FilterList].to[ExampleProjectFilters]
    bind[ComplexityFilterConfiguration].toInstance(ComplexityFilterConfiguration.DEFAULT)
  }
}
