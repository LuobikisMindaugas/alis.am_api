import i18n from "i18next";
import {initReactI18next} from "react-i18next";
import en from "./assets/en.json";
import lt from "./assets/lt.json";
import languageDetector from 'i18next-browser-languagedetector';

i18n
    .use(initReactI18next)
    .use(languageDetector)
    .init({
        resources:{
            en, lt
        },
        load: 'languageOnly',
        fallbackLng: "lt",
        interpolation: {
            escapeValue: false
        }
    })

export default i18n