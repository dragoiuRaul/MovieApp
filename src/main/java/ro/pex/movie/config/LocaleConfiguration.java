package ro.pex.movie.config;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

@Component
@Configuration
public class LocaleConfiguration {

	@Value("${application.translation.properties.basename}")
	private String propertiesBaseName;
	@Value("${application.translation.properties.defaultlocale}")
	private String defaultLocale;

	@Bean
	public LocaleResolver localeResolver() {
		AcceptHeaderLocaleResolver acceptHeaderLocaleResolver = new AcceptHeaderLocaleResolver();
		acceptHeaderLocaleResolver.setDefaultLocale(new Locale(defaultLocale));
		return acceptHeaderLocaleResolver;
	}

	@Bean(name = "textsResourceBundleMessageSource")
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource rs = new ResourceBundleMessageSource();
		rs.setBasename(propertiesBaseName);
		rs.setDefaultEncoding("UTF-8");
		rs.setUseCodeAsDefaultMessage(true);
		return rs;
	}

}
