import React from 'react';
import CssBaseline from '@material-ui/core/CssBaseline';
import Typography from '@material-ui/core/Typography';
import { makeStyles } from '@material-ui/core/styles';
import Container from '@material-ui/core/Container';
import Link from '@material-ui/core/Link';
import {useTranslation} from "react-i18next";

function Copyright() {
    return (
        <Typography variant="body2" color="textSecondary">
            {'Copyright © '}
            <Link color="inherit" href="Mindaugas Luobikis">
                Mindaugas Luobikis
            </Link>{' '}
            {new Date().getFullYear()}
            {'.'}
        </Typography>
    );
}

const useStyles = makeStyles((theme) => ({
    footer: {
        padding: theme.spacing(3, 2),
        marginTop: 'auto',
        alignContent: 'center',
        backgroundColor:
            theme.palette.type === 'light' ? theme.palette.grey[200] : theme.palette.grey[800],
    },
}));

export default function StickyFooter() {
    const classes = useStyles();
    const {t} = useTranslation()

    return (
        <>
            <CssBaseline />
            <footer className={classes.footer}>
                <Container maxWidth="sm" >
                    <Typography variant="body1">Alis.am.lt {t('footer')}</Typography>
                    <Copyright/>
                </Container>
            </footer>
        </>
    );
}