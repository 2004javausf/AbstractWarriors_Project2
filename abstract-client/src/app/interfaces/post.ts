import { User } from './users';
import { Image } from './image';

export interface Post {
    postId: number,
    message: string,
    numOfLikes: number,
    date: string,
    images: Image[],
    comments: Comment[],
    userId: number,
    likers: User[]
}