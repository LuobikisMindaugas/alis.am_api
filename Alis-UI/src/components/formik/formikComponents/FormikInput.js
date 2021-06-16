import {FormControl, FormHelperText, Input, InputLabel, OutlinedInput} from "@material-ui/core";
import {ErrorMessage, Field} from "formik";


const FormikInput = ({name, label, error, ...props}) => (
    <FormControl error={error} margin="normal" variant="outlined" fullWidth>
        <InputLabel htmlFor={name}>{label}</InputLabel>
        <Field id={name} label={label} name={name} {...props} as={OutlinedInput}/>
        <ErrorMessage name={name} component={FormHelperText}/>
    </FormControl>
)

export default FormikInput