import {configureStore} from "@reduxjs/toolkit";
import {logger} from "redux-logger/src"
import user from './slices/userSlice'

const constructStore = () => {
    const store = configureStore({
        reducer: {
            user
        },
        middleware: getDefaultMiddleware => getDefaultMiddleware().concat(logger),
    })

    return store
}

const store = constructStore()

export default store