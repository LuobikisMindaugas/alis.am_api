import {FormControl, FormHelperText, InputLabel, MenuItem, Select} from "@material-ui/core";
import React from "react";
import {ErrorMessage} from "formik";

const FormikRegionSelect = ({error, name}) => {
    return (
        <FormControl margin="normal" variant="outlined" error={error} fullWidth>
            <InputLabel htmlFor="region" margin="dense">Regionas</InputLabel>
            <Select
                labelId="region"
                inputProps={{ 'aria-label': 'Without label' }}
                area-label='region'
                label="Regionas"
            >
                <MenuItem>
                    <em></em>
                </MenuItem>
                <MenuItem value='dzukija'>Dzukija</MenuItem>
                <MenuItem value='suvalkija'>Suvalkija</MenuItem>
                <MenuItem value='aukstaitija'>Aukstaitija</MenuItem>
                <MenuItem value='zemaitija'>Zemaitija</MenuItem>
            </Select>
            <ErrorMessage name={name} component={FormHelperText}/>
        </FormControl>
    )
}

export default FormikRegionSelect