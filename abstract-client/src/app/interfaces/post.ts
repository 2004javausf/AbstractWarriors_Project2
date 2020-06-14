import { User } from './users';
import { Image } from './image';

export interface Post {
    postId: number,
    message: string,
    numOfLikes: number,
    date: any,
    postImages: Blob,
    userId: number
}