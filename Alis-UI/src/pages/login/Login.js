import {Form, Formik} from "formik"
import Button from "@material-ui/core/Button";
import {login} from "../../api/userApi";
import Container from "@material-ui/core/Container";
import FormikInput from "../../components/formik/formikComponents/FormikInput";
import {useTranslation} from "react-i18next";
import {NavLink, useLocation} from "react-router-dom";
import Link from "@material-ui/core/Link";
import React from "react";
import {useDispatch} from "react-redux";
import {login as setLogin} from '../../store/slices/userSlice'
import {useHistory} from "react-router-dom"

const Login = () => {

    const {t} = useTranslation();
    const dispatch = useDispatch()
    const history = useHistory()
    const location = useLocation()

    const postLogin = (loginData, {setSubmitting}) => {
        setSubmitting(true)

        login(loginData)
            .then(({data: loggedInUser, headers: {authorization}}) => {
                dispatch(setLogin({
                    loggedInUser,
                    jwt: authorization
                }))
                const from = location.state?.from
                history.push(from || '/')
            })
            .finally(() => setSubmitting(false))
    }

    return (
        <Formik
            initialValues={{
                username: '',
                password: ''
            }}
            onSubmit={postLogin}
        >
            {(props) => (
                <>
                    <Container maxWidth="sm">
                        <Form>
                            <div>
                                <FormikInput name="username"
                                             label={t('username')}/>
                            </div>
                            <div>
                                <FormikInput name="password"
                                             label={t('password')}
                                             type="password"/>
                            </div>

                            <Button variant="contained"
                                    fullWidth
                                    color="primary"
                                    type="submit"
                                    disabled={props.isSubmitting}>{t('submit')}</Button>
                        </Form>
                        <div style={{width: "100%", display: "flex", justifyContent: "center", marginTop: "20px"}}>
                            <Link variant="button" color="textPrimary" to="/signup" component={NavLink}>
                                {t('register')}
                            </Link>
                        </div>

                    </Container>
                </>
            )}
        </Formik>
    )
}

export default Login