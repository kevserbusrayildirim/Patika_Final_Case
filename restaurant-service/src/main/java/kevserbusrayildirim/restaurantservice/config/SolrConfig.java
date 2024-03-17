package kevserbusrayildirim.restaurantservice.config;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.Http2SolrClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;

@Configuration
@EnableSolrRepositories(
        basePackages = "kevserbusrayildirim.restaurantservice.repository"
)
@ComponentScan
public class SolrConfig {
    @Bean
    public SolrClient solrClient(){
        return new Http2SolrClient.Builder("http://localhost:8983/solr").build();
    }

    @Bean
    public SolrTemplate solrTemplate(SolrClient solrClient){
        return new SolrTemplate(solrClient);
    }
}
