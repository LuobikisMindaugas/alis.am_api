import * as Yup from "yup";
import {useTranslation} from "react-i18next";
import {Form, Formik} from "formik";
import Container from "@material-ui/core/Container";
import Button from "@material-ui/core/Button";
import React, {useEffect, useState} from "react";
import {useSelector} from "react-redux";
import {fetchAreas} from "../../../api/AreasApi";
import {makeStyles} from "@material-ui/core/styles";
import {FormControl, InputLabel, MenuItem, Select, TextField} from "@material-ui/core";
import {createLicense} from "../../../api/CreateLicenseApi";


const useStyles = makeStyles((theme) => ({
    form: {
        display: "flex",
        flexDirection: "column",
        alignItems: "center",
        justifyContent: "center",
        marginTop: 20,
        width: '30vw'
    },

    spacebetween: {
        display: "flex",
        justifyContent: "space-between"
    },

    inputspacing: {
        margin: 4
    },

    width: {
        width: '100%'
    },

    termsize: {
        width: '25%'
    },
    maxWidth: {
        maxWidth: '100vh'
    },
    marginLeft: {
        marginLeft: '10px'
    }

}));

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
    const classes = useStyles();
    const date = new Date()

    const loggedInUser = useSelector(state => state.user.loggedInUser)
    const [loading, setLoading] = useState(true)
    const {t} = useTranslation()
    const [areas, setAreas] = useState([])

    useEffect(() => {
        fetchAreas()
            .then(({data}) => {
                setAreas(data)
            }).finally(() => setLoading(false))
    }, [])

    return (
        <Formik initialValues={{
            area: '',
            datefrom: '',
            term: '',
            name: '',
            surname: ''
        }}
                validationSchema={validationSchema}
                onSubmit={createLicense}>
            {props => (
                <>
                    <Container maxWidth="xs">
                        <Form>
                            <div>
                                <FormControl className={classes.width} noValidate autoComplete="off">
                                    <InputLabel id="placeLbl">Telkinys</InputLabel>
                                    <Select
                                        labelId="placeLbl"
                                        inputProps={{'aria-label': 'Without label'}}
                                        area-label='place'
                                        name='area'
                                    >
                                        <MenuItem value="">
                                            <em></em>
                                        </MenuItem>
                                        {areas.map(area => (
                                            <MenuItem value={area.name}>{area.name}</MenuItem>
                                        ))}
                                    </Select>
                                </FormControl>
                            </div>
                            <div>
                                <FormControl className={classes.width} noValidate autoComplete="off">
                                    <TextField
                                        id="datefrom"
                                        name="datefrom"
                                        label="Leidimas nuo..."
                                        type="datetime-local"
                                        autoOk={true}
                                        defaultValue={date}
                                        InputLabelProps={{
                                            shrink: true,
                                        }}
                                    />
                                </FormControl>
                            </div>
                            <div>
                                <FormControl className={classes.width} noValidate autoComplete="off">
                                    <InputLabel id="termLbl">Terminas</InputLabel>
                                    <Select
                                        labelId="termLbl"
                                        inputProps={{'aria-label': 'Without label'}}
                                        area-label='term'
                                        name="term"
                                    >
                                        <MenuItem value="">
                                            <em></em>
                                        </MenuItem>
                                        <MenuItem value='day'>Day</MenuItem>
                                        <MenuItem value='month'>Month</MenuItem>
                                        <MenuItem value='year'>Year</MenuItem>
                                    </Select>
                                </FormControl>
                            </div>
                            <div>
                                <FormControl className={classes.width} noValidate autoComplete="off">
                                    <div className={classes.spacebetween}>
                                        <TextField className={classes.inputspacing}
                                                   id="standard-basic"
                                                   label="Vardas"
                                                   name="name"
                                                   value={loggedInUser?.name}/>
                                        <TextField className={classes.inputspacing}
                                                   id="standard-basic"
                                                   label="Pavarde"
                                                   value={loggedInUser?.surname}
                                                   name="name"/>
                                    </div>
                                </FormControl>
                            </div>
                            <div style={{display: "flex", justifyContent: "center", marginTop: "20px"}}>
                                {!props.isSubmitting ? <Button color="primary" variant="contained"
                                                               type="submit">{t('submit')}</Button> : "LOADING..."}
                            </div>
                        </Form>
                    </Container>
                </>
            )}
        </Formik>
    )
}