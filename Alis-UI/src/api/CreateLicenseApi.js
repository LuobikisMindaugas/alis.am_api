import HTTP from "./index";

const createLicense = (license) => HTTP.post('/license/new', license)

export {createLicense}