export class FileUtils {

  public static toBlob(xmlstring: string, type: string ): Blob {
    const xmlval = new DOMParser().parseFromString(xmlstring, 'application/xml');
    const base64Data = window.btoa((new XMLSerializer()).serializeToString(xmlval));

    const byteCharacters = window.atob(base64Data);
    const byteNumbers = new Array(byteCharacters.length);
    for (let i = 0; i < byteCharacters.length; i++) {
      byteNumbers[i] = byteCharacters.charCodeAt(i);
    }

    const byteArray = new Uint8Array(byteNumbers);
    return new Blob([byteArray], {type:'application/xml'});
  }


}
