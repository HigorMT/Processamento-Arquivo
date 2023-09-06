import {Component, Input, OnInit} from '@angular/core';
import {AbstractStatusDecorator} from "../../../abstract/AbstractStatusDecorator";

@Component({
    selector: 'status-badge',
    templateUrl: './status-badge.component.html',
    styleUrls: ['./status-badge.component.scss']
})
export class StatusBadgeComponent implements OnInit {

    @Input()
    public status?: AbstractStatusDecorator

    @Input()
    public showSpinner: boolean = false

    constructor() {
    }

    public ngOnInit(): void {
    }

}
