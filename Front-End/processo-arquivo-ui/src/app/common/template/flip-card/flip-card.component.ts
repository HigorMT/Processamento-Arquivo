import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';

@Component({
    selector: 'flip-card',
    templateUrl: './flip-card.component.html',
    styleUrls: ['./flip-card.component.scss']
})
export class FlipCardComponent implements OnInit {

    private rot: boolean = false;

    @Output()
    public rotateChange = new EventEmitter<boolean>();

    @Input()
    public set rotate(rotate: boolean) {
        if (this.rot !== rotate) {
            this.rot = rotate;
            this.rotateChange.emit(rotate)
        }
    }

    public get rotate(): boolean {
        return this.rot;
    }

    public get class(): string {
        if (this.rotate) {
            return `rotate-front`;
        }
        else return `rotate-back`
    }

    public end = true;
    public style = 'flat';

    constructor() {
    }

    public ngOnInit(): void {
    }

    public flip(rotate: boolean): void {
        if (this.rotate !== rotate) {
            this.end = false;
            this.rotate = rotate;
            this.style = 'preserve-3d';
            this.endEvent();
            if (!this.rotate)
                setTimeout(() => {this.style = 'flat'}, 1000)
        }
    }

    private endEvent(): void {
        setTimeout(() => {this.end = true}, 900);
    }

}
