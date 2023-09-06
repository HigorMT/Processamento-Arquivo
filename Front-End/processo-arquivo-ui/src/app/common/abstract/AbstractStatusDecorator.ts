export abstract class AbstractStatusDecorator<ENUM = any> {
  id?: number
  descricao?: string
  style?: string
  value?: ENUM
}
