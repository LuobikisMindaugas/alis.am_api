import {fetchAreas} from "../../api/AreasApi";
import {useEffect, useState} from "react";
import {
    CircularProgress,
    Container,
    Paper,
    Table,
    TableBody,
    TableCell,
    TableContainer,
    TableHead,
    TableRow
} from "@material-ui/core";
import {useTranslation} from "react-i18next";


const Areas = () => {


    const [loading, setLoading] = useState(true)
    const {t} = useTranslation()
    const [areas, setAreas] = useState([])

    useEffect( () => {
        fetchAreas()
            .then(({data}) => {
                setAreas(data)
            }).finally(() => setLoading(false))
    }, [])


        return (
            <>
                <Container maxWidth="sm">
                    <h3>{t('areas')}</h3>
                    <TableContainer component={Paper}>
                        <Table aria-label="simple table">
                            <TableHead>
                                <TableRow>
                                    <TableCell></TableCell>
                                    <TableCell align="right">{t('areaName')}</TableCell>
                                    <TableCell align="right">{t('dayprice')}</TableCell>
                                    <TableCell align="right">{t('monthprice')}</TableCell>
                                    <TableCell align="right">{t('yearprice')}</TableCell>
                                </TableRow>
                            </TableHead>
                            {loading ?
                                <CircularProgress/> :
                                <TableBody>
                                    {areas.map(area => (
                                        <TableRow key={area.id}>
                                            <TableCell component="th" scope="row"></TableCell>
                                            <TableCell align="right">{area.name}</TableCell>
                                            <TableCell align="right">{area.dayprice}</TableCell>
                                            <TableCell align="right">{area.monthprice}</TableCell>
                                            <TableCell align="right">{area.yearprice}</TableCell>
                                        </TableRow>
                                    ))}
                                </TableBody>
                            }
                        </Table>
                    </TableContainer>
                </Container>
            </>
        )
}
export default Areas