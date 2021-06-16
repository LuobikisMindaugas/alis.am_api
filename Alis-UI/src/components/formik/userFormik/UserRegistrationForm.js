import {Form, Formik} from "formik"
import * as Yup from "yup";
import React from "react";

import FormikInput from "../formikComponents/FormikInput";
import Container from "@material-ui/core/Container";
import Button from "@material-ui/core/Button";
import {registration} from "../../../api/UserRegistrationApi";
import {useTranslation} from "react-i18next";


const validationSchema = Yup.object().shape({
    name: Yup.string()
        .required("Laukas yra privalomas"),
    surname: Yup.string()
        .required("Laukas yra privalomas"),
    email: Yup.string()
        .email()
        .required("Laukas yra privalomas"),
    password: Yup.string()
        .min(5)
        .required("Laukas yra privalomas")
});

export default () => {
    const {t} = useTranslation();
    return (
        <Formik initialValues={{
            name: '',
            surname: '',
            email: '',
            username: '',
            password: ''
        }}
                validationSchema={validationSchema}
                onSubmit={registration}>
            {props => (
                <>
                    <Container maxWidth="xs">
                        <Form>
                            <div>
                                <FormikInput name="name" label={t('name')}
                                             error={props.touched.name && !!props.errors.name}/>
                            </div>
                            <div>
                                <FormikInput name="surname" label={t('surname')}
                                             error={props.touched.surname && !!props.errors.surname}/>
                            </div>
                            <div>
                                <FormikInput name="username" label={t('username')}
                                             error={props.touched.username && !!props.errors.username}/>
                            </div>
                            <div>
                                <FormikInput name="email" label={t('email')}
                                             error={props.touched.email && !!props.errors.email}/>
                            </div>
                            <div>
                                <FormikInput name="password"
                                             type="password"
                                             label={t('password')}
                                             error={props.touched.password && !!props.errors.dayprice}/>
                            </div>
                            {!props.isSubmitting ? <Button color="primary" variant="contained" type="submit">{t('submit')}</Button> : "LOADING..."}
                        </Form>
                    </Container>
                </>
            )}
        </Formik>
    )
}