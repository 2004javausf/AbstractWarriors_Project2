import { ACTION_SEARCH} from '../actions/appActions';
import { User } from 'src/app/interfaces/users';


export interface otherUserReducerState {
    otherUser?: User //Find a way to grab user from SpringBoot
}

const initialState: otherUserReducerState = {
    otherUser: null
}

export function userReducer(state = initialState, action): otherUserReducerState {
    switch(action.type) {
        case ACTION_SEARCH:
            return {
                ...state,
                otherUser: action.payload
            }

    }
    return state
}