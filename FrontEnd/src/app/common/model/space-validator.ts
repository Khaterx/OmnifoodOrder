import {AbstractControl, FormControl, ValidationErrors} from "@angular/forms";

export class SpaceValidator {
  static noSpaceAllowed(control: AbstractControl): ValidationErrors | null {
    if ((control.value as string).indexOf(' ') >= 0) {
      control.value.trim().length === 0;
      return {noSpaceAllowed: true}
    }

    return null;
  }
}
