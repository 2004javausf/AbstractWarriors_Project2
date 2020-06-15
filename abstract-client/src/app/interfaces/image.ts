import { Post } from './post';

export interface Image {
    imageId: number,
    image: string,
    type: string,
    picByte: Blob,
    post: Post

}