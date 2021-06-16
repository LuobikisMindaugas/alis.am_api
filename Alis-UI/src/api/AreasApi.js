import HTTP from "./index";

const fetchAreas = () => HTTP.get('/areas')


export {fetchAreas}