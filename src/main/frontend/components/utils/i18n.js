import i18n from "i18next";
import LanguageDetector from "i18next-browser-languagedetector";
import { initReactI18next } from "react-i18next";
import I18nUtils from "./I18nUtils.js";

i18n.use(LanguageDetector).init({
	detection: {
		// order and from where user language should be detected
		order: ['querystring', 'cookie', 'localStorage', 'sessionStorage', 'navigator', 'htmlTag', 'path', 'subdomain'],

		lookupQuerystring: 'lng',
	},
});

i18n.use(initReactI18next)
	.init({
		react: {
			useSuspense: false,
			wait: true,
		},
		fallbackLng: "en",
		lng: window.navigator.userLanguage || window.navigator.language,
		resources: I18nUtils.translationsData
	});

export default i18n;