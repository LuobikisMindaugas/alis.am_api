import "./style.css"
import Footer from "./components/footer/Footer";
import Container from "@material-ui/core/Container";
import Header from "./components/header/Header";
import {makeStyles} from "@material-ui/core/styles";
import Content from "./components/content/Content";
import {BrowserRouter as Router, Route, Switch} from "react-router-dom";
import store from "./store";
import {Provider} from "react-redux";

const useStyles = makeStyles((theme) => ({
    root: {
        display: 'flex',
        flexDirection: 'column',
        minHeight: '100vh'
    }
}));



function App() {
    const classes = useStyles();

    return (
        <Router>
            <Provider store={store}>
                <Container className={classes.root}>
                    <Header></Header>
                    <Content></Content>
                    <Footer></Footer>
                </Container>
            </Provider>
        </Router>
    );
}

export default App;

