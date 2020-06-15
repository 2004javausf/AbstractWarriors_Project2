import { reducer, appReducerState} from './appReducer'
import {ActionReducerMap} from '@ngrx/store'
import { otherUserReducerState, userReducer } from './otherUserReducer'


interface AppState {
    appReducer: appReducerState
}
export const reducers: ActionReducerMap<AppState> = {
    appReducer: reducer
}

interface UserAppState {
    otherUserReducer: otherUserReducerState
}

export const userReducers: ActionReducerMap<UserAppState> = {
    otherUserReducer: userReducer
}