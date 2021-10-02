package za.ac.nwu.ac.translator.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import za.ac.nwu.ac.repo.config.RepositoryConfiguration;

@Import({RepositoryConfiguration.class})
@Configuration
@ComponentScan(basePackages={ "za.ac.nwu.ac.translator"})
public class TranslatorConfig {
    /* idee
    RewardsRepository rewardsRepository;

    @Autowired
    public TranslatorConfig (RewardsRepository rewardsRepository){
        this.rewardsRepository = rewardsRepository;
    }*/
}
