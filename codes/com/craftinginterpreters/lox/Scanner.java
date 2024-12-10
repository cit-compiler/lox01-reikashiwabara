public class Scanner {
    
    break;
    case '/':
      if (match('/')) {
        // A comment goes until the end of the line.
        while (peek() != '\n' && !isAtEnd()) advance();
      } else {
        addToken(SLASH);
      }
      break;

    default:

}
