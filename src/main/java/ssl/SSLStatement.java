package ssl;
/* Generated By:JJTree: Do not edit this line. SSLStatement.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=SSL,NODE_EXTENDS=BaseNode,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
public
class SSLStatement extends SimpleNode {
  public SSLStatement(int id) {
    super(id);
  }

  public SSLStatement(ExpressionParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public String jjtAccept(ExpressionParserVisitor visitor, String data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=c8b15c0ffeb3c541a59af41a40bb7090 (do not edit this line) */
