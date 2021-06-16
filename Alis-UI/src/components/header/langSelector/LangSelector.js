import {useTranslation} from "react-i18next";
import i18n from "i18next";
import {useState} from "react";
import {MenuItem, Select} from "@material-ui/core";

export default function LangSelector(){

    const {t} = useTranslation();

    const handleLangChange = (e) => {
        i18n.changeLanguage(e.target.value)
        setLanguage(e.target.value)
    }

    const [language, setLanguage] = useState('lt');

    return (
        <Select
            labelId="langSelect"
            id="langSelect"
            defaultValue={language}
            onChange={handleLangChange}
            label="Language">
            <MenuItem value='en'>EN</MenuItem>
            <MenuItem value='lt'>LT</MenuItem>

        </Select>
    )
}