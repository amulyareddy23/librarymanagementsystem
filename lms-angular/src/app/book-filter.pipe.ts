import { PipeTransform, Pipe } from '@angular/core';


interface Book {
    bid: number;
    bookName: string;
    author: string;
    category: string;
    publisher: string;
}


@Pipe({
    name: 'bookFilter'
})
export class BookFilterPipe implements PipeTransform {
    transform(booksInfo: Book[], searchTerm: string): Book[] {
        if (searchTerm === undefined) {
           return booksInfo;
        } else {
            return booksInfo.filter(book => {
                return book.bookName.toLowerCase().includes(searchTerm.toLowerCase()) || 
                        book.author.toLowerCase().includes(searchTerm.toLowerCase()) ||
                        book.category.toLowerCase().includes(searchTerm.toLowerCase());
            });

        }
    }
}