
import {ACTION_LOGOUT, ACTION_LOGIN} from '../actions/appActions';
import { UsersService } from 'src/app/services/users.service';
import { User } from 'src/app/interfaces/users';




export interface appReducerState {
    isLoggedIn: boolean,
    user?: User //Find a way to grab user from SpringBoot
}

const initialState: appReducerState = {
    isLoggedIn: false,
    user: null
}

export function reducer(state = initialState, action): appReducerState {
    switch(action.type) {
        case ACTION_LOGOUT:
            return {
                ...state,
                isLoggedIn: false,
                user: null
            }
        case ACTION_LOGIN:
            return {
                ...state,
                isLoggedIn: true,
                user: action.payload
            }
    }
    return state
}