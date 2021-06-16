
import {makeStyles} from "@material-ui/core/styles";
import CreateAreaWithFormik from "../formik/areaFormik/CreateAreaWithFormik";
import {Switch, Route} from "react-router-dom";
import LandingPage from "../../pages/landingPage/LandingPage";
import Areas from "../../pages/areas/Areas";
import SignUp from "../../pages/signup/SignUp";
import Login from "../../pages/login/Login";
import CreateLicenseWithFormik from "../formik/licenseFormik/CreateLicenseWithFormik";
import PrivateRoute from "../privateRoute/PrivateRoute";
import CreateLicenseFormik from "../formik/licenseFormik/CreateLicenseFormik";

export default () => {
    return (
        <>
            <Switch>
                <Route exact path="/">
                    <LandingPage/>
                </Route>
                <Route exact path="/areas">
                    <Areas/>
                </Route>
                <PrivateRoute roles={["ADMIN"]} path="/areas/new">
                    <CreateAreaWithFormik/>
                </PrivateRoute>
                {/*<Route exact path="/area/:id" children={<ItemPage/>}>*/}
                {/*    <ItemPage/>*/}
                {/*</Route>*/}
                <Route exact path="/signup">
                    <SignUp/>
                </Route>
                <Route path="/login">
                    <Login/>
                </Route>
                <PrivateRoute roles={["USER"]} path="/license/new">
                    <CreateLicenseFormik/>
                </PrivateRoute>
            </Switch>
        </>
    )
}