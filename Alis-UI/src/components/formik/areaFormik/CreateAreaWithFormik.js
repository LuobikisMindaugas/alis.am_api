import {Form, Formik} from "formik"
import * as Yup from "yup";
import React from "react";
import FormikRegionSelect from "../formikComponents/FormikRegionSelect";
import FormikInput from "../formikComponents/FormikInput";
import Container from "@material-ui/core/Container";
import Button from "@material-ui/core/Button";
import {useTranslation} from "react-i18next";

const regionOptions = [
    {value: "Dzukija", label: "Dzukija"},
    {value: "Suvalkija", label: "Suvalkija"},
    {value: "Aukstaitija", label: "Aukstaitija"},
    {value: "Zemaitija", label: "Zemaitija"}
];


const validationSchema = Yup.object().shape({
    region: Yup.string()
        .required("Topic is required!"),
    name: Yup.string()
        .required()
        .min(5, "Reiksme turi buti ne trumpesne kaip 5 simboliai")
        .max(20, "Ne ilgesne kaip 20"),
    dayprice: Yup.number()
        .required("Butina ivest suma"),
    monthprice: Yup.number()
        .required("Butina ivest suma"),
    yearprice: Yup.number()
        .required("Butina ivest suma")
});

export default () => {
    const {t} = useTranslation()
    return (
        <Formik initialValues={{
            region: '',
            name: '',
            dayprice: '',
            monthprice: '',
            yearprice: ''
        }}

                validationSchema={validationSchema}>
            {props => (
                <>
                    <Container maxWidth="xs">
                        <Form>
                            <div>
                                <FormikInput name="name" label={t('areaName')}
                                                error={props.touched.name && !!props.errors.name}/>
                            </div>
                            <div>
                                <FormikInput name="dayprice" label={t('dayprice')}
                                             error={props.touched.dayprice && !!props.errors.dayprice}/>
                            </div>
                            <div>
                                <FormikInput name="monthprice" label={t('monthprice')}
                                             error={props.touched.monthprice && !!props.errors.monthprice}/>
                            </div>
                            <div>
                                <FormikInput name="yearprice" label={t('yearprice')}
                                             error={props.touched.yearprice && !!props.errors.yearprice}/>
                            </div>
                            {!props.isSubmitting ? <Button color="primary" variant="contained" type="submit">{t('submit')}</Button> : "LOADING..."}
                        </Form>
                    </Container>
                </>
            )}
        </Formik>
    )
}