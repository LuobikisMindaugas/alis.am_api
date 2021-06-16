import AppBar from "@material-ui/core/AppBar";
import Toolbar from "@material-ui/core/Toolbar";
import Typography from "@material-ui/core/Typography";
import Link from "@material-ui/core/Link";
import Button from "@material-ui/core/Button";
import React from "react";
import {makeStyles} from "@material-ui/core/styles";
import CssBaseline from "@material-ui/core/CssBaseline";
import {NavLink} from "react-router-dom";
import {useTranslation} from "react-i18next";
import LangSelector from "./langSelector/LangSelector";
import {useDispatch, useSelector} from "react-redux";
import store from "../../store";
import {login} from "../../store/slices/userSlice";

const useStyles = makeStyles((theme) => ({
    appBar: {
        borderBottom: `1px solid ${theme.palette.divider}`,
    },
    toolbar: {
        flexWrap: 1,
    },
    toolbarTitle: {
        flexGrow: 1,
    },
    link: {
        margin: theme.spacing(1, 1.5),
    },
    active: {
        fontWeight: "bolder",
        color: "blue"
    }
}));

export default () => {


    const classes = useStyles();
    const {t} = useTranslation()
    const loggedInUser = useSelector(state => state.user.loggedInUser)

    return (
        <React.Fragment>
            <CssBaseline/>
            <AppBar position="static" color="default" elevation={0} className={classes.appBar}>
                <Toolbar className={classes.toolbar} style={{display: "flex", justifyContent: "space-between"}}>
                    <Link variant="button" color="textPrimary" to="/"
                          component={NavLink}>
                        <Typography variant="h6" color="inherit" noWrap className={classes.toolbarTitle}>
                            Alis.am.lt
                        </Typography>
                    </Link>
                    <div style={{display: "flex", alignItems: "center"}}>
                        <nav>
                            {
                                loggedInUser?.roles.includes('ADMIN') ?
                            <Link variant="button" color="textPrimary" to="/areas/new"
                                  className={classes.link} activeClassName={classes.active} component={NavLink}>
                                {t('createArea')}
                            </Link> : <></>
                            }
                            <Link variant="button" color="textPrimary" to="/areas"
                                  className={classes.link} activeClassName={classes.active} component={NavLink}>
                                {t('areas')}
                            </Link>
                        </nav>

                        <div>
                            {loggedInUser?.name ?
                                <div style={{display: "flex"}}>
                                    <h4>{loggedInUser?.name}</h4>
                                    <Button color="primary" variant="outlined" className={classes.link} href="/">
                                        {t('logout')}
                                    </Button>
                                </div>
                                :
                                <Link variant="button" color="textPrimary" to="/login"
                                component={NavLink}>
                                <Button color="primary" variant="outlined" className={classes.link}>
                            {t('login')}
                                </Button>
                                </Link>

                            }
                        </div>
                        <LangSelector/>
                    </div>
                </Toolbar>
            </AppBar>
        </React.Fragment>

    );
}
