package ro.pex.movie.service.i18n;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Service;

@Service
public class I18nService {

	
	@Autowired
	@Qualifier("textsResourceBundleMessageSource")
	private ResourceBundleMessageSource messageSource;
	
	public String getTranslation(String code) {
		
		Locale locale=LocaleContextHolder.getLocale();
		return messageSource.getMessage(code, null, locale);
	}
}
