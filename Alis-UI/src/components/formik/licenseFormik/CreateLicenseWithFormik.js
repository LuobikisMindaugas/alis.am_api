import {Form, Formik} from "formik"
import * as Yup from "yup";
import {makeStyles} from "@material-ui/core/styles";
import {Container, FormControl, InputLabel, MenuItem, Select, TextField} from "@material-ui/core";
import React, {useEffect, useState} from "react";
import {useTranslation} from "react-i18next";
import {fetchAreas} from "../../../api/AreasApi";
import {useSelector} from "react-redux";
import {createLicense} from "../../../api/CreateLicenseApi";
import Button from "@material-ui/core/Button";

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
    region: Yup.string()
        .ensure()
        .required("Topic is required!"),
    name: Yup.string()
        .required()
        .min(5, "Reiksme turi buti ne trumpesne kaip 5 simboliai")
        .max(20, "Ne ilgesne kaip 20"),
    surname: Yup.string()
        .required()
        .min(5, "Reiksme turi buti ne trumpesne kaip 5 simboliai")
        .max(20, "Ne ilgesne kaip 20")
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
        <Container maxWidth="xs" style={{display: "flex", flexDirection: "column"}}>
            <Formik initialValues={{
                area: '',
                dateStart: '',
                term: '',
                name: '',
                surname: ''
            }}
                    validationSchema={validationSchema}
                    onSubmit={createLicense}>
                <Form>
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
                    <Button color="primary" variant="contained" type="submit">{t('submit')}</Button>
                </Form>
            </Formik>
        </Container>
    )
}