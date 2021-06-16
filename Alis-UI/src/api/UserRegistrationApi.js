import HTTP from "./index";

const registration = (user) => HTTP.post('/users', user)

export { registration }