import {useTranslation} from "react-i18next";
import {Container, responsiveFontSizes} from "@material-ui/core";
import Button from "@material-ui/core/Button";
import React from "react";
import {NavLink} from "react-router-dom";
import Link from "@material-ui/core/Link";
import img from '../../assets/img/img.JPG';

const LandingPage = () => {

    const {t} = useTranslation()

    return (
        <>
            <img src={img} style={{maxHeight: "200px", maxWidth: "100%", margin:"1", objectFit: "cover"}}/>
            <Container maxWidth="md">
                <p style={{fontSize: "x-large", textAlign: "center"}}>
                    {t("paragraph:text")}
                </p>
                <div style={{alignContent: "center", display: "flex", justifyContent: "center", width: "100%"}}>
                    <Link variant="button" color="textPrimary" to="/license/new"
                           component={NavLink}>
                        <Button color="primary" variant="outlined">
                            {t('buylicense')}
                        </Button>
                    </Link>

                </div>
            </Container>
        </>
    )
}

export default LandingPage