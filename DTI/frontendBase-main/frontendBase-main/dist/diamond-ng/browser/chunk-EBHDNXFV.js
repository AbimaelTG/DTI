import{a as Ee,b as Ne,c as He,d as Be}from"./chunk-FRMTSDKC.js";import{Aa as Le,Ba as Ie,Ca as Se,Da as Ve,Ea as Fe,Ga as Te,Ka as De,La as Ze,Ma as je,a as A,ba as fe,c as pe,ca as ge,e as ue,g as k,ha as xe,ja as ke,k as he,ka as z,p as me,q as be,ra as Ce,ua as ve,va as ye,wa as we,xa as _e,ya as Me}from"./chunk-4GW6BUX4.js";import{$ as h,Ab as ce,Ba as w,Bb as b,Cb as u,Eb as ae,Ha as p,Ia as ne,Jb as se,La as T,Mb as j,Na as _,O as K,P as I,Pa as E,Q as X,T as ee,U as S,Vb as le,Ya as f,Yb as $,Z as V,_ as F,bb as s,cb as r,db as c,dc as M,eb as a,ec as de,fa as te,fb as N,gb as D,hb as g,ib as U,ja as oe,jb as Q,ka as y,lb as ie,nb as H,ob as x,rb as q,sb as re,tb as B,ub as Z,wa as d}from"./chunk-ZS4RC7DI.js";var Pe=["data-p-icon","minus"],Ae=(()=>{class e extends De{static \u0275fac=(()=>{let t;return function(o){return(t||(t=y(e)))(o||e)}})();static \u0275cmp=p({type:e,selectors:[["","data-p-icon","minus"]],features:[T],attrs:Pe,decls:1,vars:0,consts:[["d","M13.2222 7.77778H0.777778C0.571498 7.77778 0.373667 7.69584 0.227806 7.54998C0.0819442 7.40412 0 7.20629 0 7.00001C0 6.79373 0.0819442 6.5959 0.227806 6.45003C0.373667 6.30417 0.571498 6.22223 0.777778 6.22223H13.2222C13.4285 6.22223 13.6263 6.30417 13.7722 6.45003C13.9181 6.5959 14 6.79373 14 7.00001C14 7.20629 13.9181 7.40412 13.7722 7.54998C13.6263 7.69584 13.4285 7.77778 13.2222 7.77778Z","fill","currentColor"]],template:function(n,o){n&1&&(h(),g(0,"path",0))},encapsulation:2})}return e})();var ze=`
    .p-checkbox {
        position: relative;
        display: inline-flex;
        user-select: none;
        vertical-align: bottom;
        width: dt('checkbox.width');
        height: dt('checkbox.height');
    }

    .p-checkbox-input {
        cursor: pointer;
        appearance: none;
        position: absolute;
        inset-block-start: 0;
        inset-inline-start: 0;
        width: 100%;
        height: 100%;
        padding: 0;
        margin: 0;
        opacity: 0;
        z-index: 1;
        outline: 0 none;
        border: 1px solid transparent;
        border-radius: dt('checkbox.border.radius');
    }

    .p-checkbox-box {
        display: flex;
        justify-content: center;
        align-items: center;
        border-radius: dt('checkbox.border.radius');
        border: 1px solid dt('checkbox.border.color');
        background: dt('checkbox.background');
        width: dt('checkbox.width');
        height: dt('checkbox.height');
        transition:
            background dt('checkbox.transition.duration'),
            color dt('checkbox.transition.duration'),
            border-color dt('checkbox.transition.duration'),
            box-shadow dt('checkbox.transition.duration'),
            outline-color dt('checkbox.transition.duration');
        outline-color: transparent;
        box-shadow: dt('checkbox.shadow');
    }

    .p-checkbox-icon {
        transition-duration: dt('checkbox.transition.duration');
        color: dt('checkbox.icon.color');
        font-size: dt('checkbox.icon.size');
        width: dt('checkbox.icon.size');
        height: dt('checkbox.icon.size');
    }

    .p-checkbox:not(.p-disabled):has(.p-checkbox-input:hover) .p-checkbox-box {
        border-color: dt('checkbox.hover.border.color');
    }

    .p-checkbox-checked .p-checkbox-box {
        border-color: dt('checkbox.checked.border.color');
        background: dt('checkbox.checked.background');
    }

    .p-checkbox-checked .p-checkbox-icon {
        color: dt('checkbox.icon.checked.color');
    }

    .p-checkbox-checked:not(.p-disabled):has(.p-checkbox-input:hover) .p-checkbox-box {
        background: dt('checkbox.checked.hover.background');
        border-color: dt('checkbox.checked.hover.border.color');
    }

    .p-checkbox-checked:not(.p-disabled):has(.p-checkbox-input:hover) .p-checkbox-icon {
        color: dt('checkbox.icon.checked.hover.color');
    }

    .p-checkbox:not(.p-disabled):has(.p-checkbox-input:focus-visible) .p-checkbox-box {
        border-color: dt('checkbox.focus.border.color');
        box-shadow: dt('checkbox.focus.ring.shadow');
        outline: dt('checkbox.focus.ring.width') dt('checkbox.focus.ring.style') dt('checkbox.focus.ring.color');
        outline-offset: dt('checkbox.focus.ring.offset');
    }

    .p-checkbox-checked:not(.p-disabled):has(.p-checkbox-input:focus-visible) .p-checkbox-box {
        border-color: dt('checkbox.checked.focus.border.color');
    }

    .p-checkbox.p-invalid > .p-checkbox-box {
        border-color: dt('checkbox.invalid.border.color');
    }

    .p-checkbox.p-variant-filled .p-checkbox-box {
        background: dt('checkbox.filled.background');
    }

    .p-checkbox-checked.p-variant-filled .p-checkbox-box {
        background: dt('checkbox.checked.background');
    }

    .p-checkbox-checked.p-variant-filled:not(.p-disabled):has(.p-checkbox-input:hover) .p-checkbox-box {
        background: dt('checkbox.checked.hover.background');
    }

    .p-checkbox.p-disabled {
        opacity: 1;
    }

    .p-checkbox.p-disabled .p-checkbox-box {
        background: dt('checkbox.disabled.background');
        border-color: dt('checkbox.checked.disabled.border.color');
    }

    .p-checkbox.p-disabled .p-checkbox-box .p-checkbox-icon {
        color: dt('checkbox.icon.disabled.color');
    }

    .p-checkbox-sm,
    .p-checkbox-sm .p-checkbox-box {
        width: dt('checkbox.sm.width');
        height: dt('checkbox.sm.height');
    }

    .p-checkbox-sm .p-checkbox-icon {
        font-size: dt('checkbox.icon.sm.size');
        width: dt('checkbox.icon.sm.size');
        height: dt('checkbox.icon.sm.size');
    }

    .p-checkbox-lg,
    .p-checkbox-lg .p-checkbox-box {
        width: dt('checkbox.lg.width');
        height: dt('checkbox.lg.height');
    }

    .p-checkbox-lg .p-checkbox-icon {
        font-size: dt('checkbox.icon.lg.size');
        width: dt('checkbox.icon.lg.size');
        height: dt('checkbox.icon.lg.size');
    }
`;var Ue=["checkboxicon"],Qe=["input"],qe=(e,i)=>({checked:e,class:i});function $e(e,i){if(e&1&&a(0,"span",7),e&2){let t=x(3);b(t.cx("icon")),s("ngClass",t.checkboxIcon),f("data-pc-section","icon")}}function Je(e,i){if(e&1&&(h(),a(0,"svg",8)),e&2){let t=x(3);b(t.cx("icon")),f("data-pc-section","icon")}}function Ye(e,i){if(e&1&&(U(0),_(1,$e,1,4,"span",5)(2,Je,1,3,"svg",6),Q()),e&2){let t=x(2);d(),s("ngIf",t.checkboxIcon),d(),s("ngIf",!t.checkboxIcon)}}function Ke(e,i){if(e&1&&(h(),a(0,"svg",9)),e&2){let t=x(2);b(t.cx("icon")),f("data-pc-section","icon")}}function Xe(e,i){if(e&1&&(U(0),_(1,Ye,3,2,"ng-container",2)(2,Ke,1,3,"svg",4),Q()),e&2){let t=x();d(),s("ngIf",t.checked),d(),s("ngIf",t._indeterminate())}}function et(e,i){}function tt(e,i){e&1&&_(0,et,0,0,"ng-template")}var ot=`
    ${ze}

    /* For PrimeNG */
    p-checkBox.ng-invalid.ng-dirty .p-checkbox-box,
    p-check-box.ng-invalid.ng-dirty .p-checkbox-box,
    p-checkbox.ng-invalid.ng-dirty .p-checkbox-box {
        border-color: dt('checkbox.invalid.border.color');
    }
`,nt={root:({instance:e})=>["p-checkbox p-component",{"p-checkbox-checked p-highlight":e.checked,"p-disabled":e.$disabled(),"p-invalid":e.invalid(),"p-variant-filled":e.$variant()==="filled","p-checkbox-sm p-inputfield-sm":e.size()==="small","p-checkbox-lg p-inputfield-lg":e.size()==="large"}],box:"p-checkbox-box",input:"p-checkbox-input",icon:"p-checkbox-icon"},Ge=(()=>{class e extends Ce{name="checkbox";theme=ot;classes=nt;static \u0275fac=(()=>{let t;return function(o){return(t||(t=y(e)))(o||e)}})();static \u0275prov=I({token:e,factory:e.\u0275fac})}return e})();var it={provide:ve,useExisting:K(()=>G),multi:!0},G=(()=>{class e extends Ze{value;binary;ariaLabelledBy;ariaLabel;tabindex;inputId;inputStyle;styleClass;inputClass;indeterminate=!1;formControl;checkboxIcon;readonly;autofocus;trueValue=!0;falseValue=!1;variant=$();size=$();onChange=new E;onFocus=new E;onBlur=new E;inputViewChild;get checked(){return this._indeterminate()?!1:this.binary?this.modelValue()===this.trueValue:ge(this.value,this.modelValue())}_indeterminate=te(void 0);checkboxIconTemplate;templates;_checkboxIconTemplate;focused=!1;_componentStyle=S(Ge);$variant=le(()=>this.variant()||this.config.inputStyle()||this.config.inputVariant());ngAfterContentInit(){this.templates.forEach(t=>{switch(t.getType()){case"icon":this._checkboxIconTemplate=t.template;break;case"checkboxicon":this._checkboxIconTemplate=t.template;break}})}ngOnChanges(t){super.ngOnChanges(t),t.indeterminate&&this._indeterminate.set(t.indeterminate.currentValue)}updateModel(t){let n,o=this.injector.get(we,null,{optional:!0,self:!0}),l=o&&!this.formControl?o.value:this.modelValue();this.binary?(n=this._indeterminate()?this.trueValue:this.checked?this.falseValue:this.trueValue,this.writeModelValue(n),this.onModelChange(n)):(this.checked||this._indeterminate()?n=l.filter(m=>!fe(m,this.value)):n=l?[...l,this.value]:[this.value],this.onModelChange(n),this.writeModelValue(n),this.formControl&&this.formControl.setValue(n)),this._indeterminate()&&this._indeterminate.set(!1),this.onChange.emit({checked:n,originalEvent:t})}handleChange(t){this.readonly||this.updateModel(t)}onInputFocus(t){this.focused=!0,this.onFocus.emit(t)}onInputBlur(t){this.focused=!1,this.onBlur.emit(t),this.onModelTouched()}focus(){this.inputViewChild.nativeElement.focus()}writeControlValue(t,n){n(t),this.cd.markForCheck()}static \u0275fac=(()=>{let t;return function(o){return(t||(t=y(e)))(o||e)}})();static \u0275cmp=p({type:e,selectors:[["p-checkbox"],["p-checkBox"],["p-check-box"]],contentQueries:function(n,o,l){if(n&1&&(q(l,Ue,4),q(l,ke,4)),n&2){let m;B(m=Z())&&(o.checkboxIconTemplate=m.first),B(m=Z())&&(o.templates=m)}},viewQuery:function(n,o){if(n&1&&re(Qe,5),n&2){let l;B(l=Z())&&(o.inputViewChild=l.first)}},hostVars:5,hostBindings:function(n,o){n&2&&(f("data-p-highlight",o.checked)("data-p-checked",o.checked)("data-p-disabled",o.$disabled()),b(o.cn(o.cx("root"),o.styleClass)))},inputs:{value:"value",binary:[2,"binary","binary",M],ariaLabelledBy:"ariaLabelledBy",ariaLabel:"ariaLabel",tabindex:[2,"tabindex","tabindex",de],inputId:"inputId",inputStyle:"inputStyle",styleClass:"styleClass",inputClass:"inputClass",indeterminate:[2,"indeterminate","indeterminate",M],formControl:"formControl",checkboxIcon:"checkboxIcon",readonly:[2,"readonly","readonly",M],autofocus:[2,"autofocus","autofocus",M],trueValue:"trueValue",falseValue:"falseValue",variant:[1,"variant"],size:[1,"size"]},outputs:{onChange:"onChange",onFocus:"onFocus",onBlur:"onBlur"},features:[se([it,Ge]),T,oe],decls:5,vars:22,consts:[["input",""],["type","checkbox",3,"focus","blur","change","checked"],[4,"ngIf"],[4,"ngTemplateOutlet","ngTemplateOutletContext"],["data-p-icon","minus",3,"class",4,"ngIf"],[3,"class","ngClass",4,"ngIf"],["data-p-icon","check",3,"class",4,"ngIf"],[3,"ngClass"],["data-p-icon","check"],["data-p-icon","minus"]],template:function(n,o){if(n&1){let l=ie();r(0,"input",1,0),H("focus",function(v){return V(l),F(o.onInputFocus(v))})("blur",function(v){return V(l),F(o.onInputBlur(v))})("change",function(v){return V(l),F(o.handleChange(v))}),c(),r(2,"div"),_(3,Xe,3,2,"ng-container",2)(4,tt,1,0,null,3),c()}n&2&&(ce(o.inputStyle),b(o.cn(o.cx("input"),o.inputClass)),s("checked",o.checked),f("id",o.inputId)("value",o.value)("name",o.name())("tabindex",o.tabindex)("required",o.required()?"":void 0)("readonly",o.readonly?"":void 0)("disabled",o.$disabled()?"":void 0)("aria-labelledby",o.ariaLabelledBy)("aria-label",o.ariaLabel),d(2),b(o.cx("box")),d(),s("ngIf",!o.checkboxIconTemplate&&!o._checkboxIconTemplate),d(),s("ngTemplateOutlet",o.checkboxIconTemplate||o._checkboxIconTemplate)("ngTemplateOutletContext",j(19,qe,o.checked,o.cx("icon"))))},dependencies:[k,A,pe,ue,He,Ae,z],encapsulation:2,changeDetection:0})}return e})(),Re=(()=>{class e{static \u0275fac=function(n){return new(n||e)};static \u0275mod=ne({type:e});static \u0275inj=X({imports:[G,z,z]})}return e})();var R=class e{static \u0275fac=function(t){return new(t||e)};static \u0275cmp=p({type:e,selectors:[["app-apple-widget"]],decls:2,vars:0,consts:[["xmlns","http://www.w3.org/2000/svg","width","21","height","20","viewBox","0 0 21 20","fill","none ",1,"fill-surface-950","dark:fill-surface-0"],["d","M14.8685 9.63602C14.8896 11.906 16.8599 12.6614 16.8817 12.671C16.865 12.7243 16.5669 13.7475 15.8437 14.8044C15.2184 15.7182 14.5696 16.6286 13.5474 16.6475C12.5431 16.666 12.2201 16.0519 11.0718 16.0519C9.92388 16.0519 9.56505 16.6286 8.6143 16.666C7.62765 16.7034 6.87631 15.6779 6.24594 14.7675C4.95782 12.9052 3.97343 9.50507 5.29522 7.20995C5.95186 6.07018 7.12532 5.34843 8.39901 5.32992C9.36787 5.31144 10.2823 5.98174 10.8746 5.98174C11.4666 5.98174 12.5778 5.17565 13.7461 5.29403C14.2352 5.31439 15.608 5.49159 16.4896 6.78194C16.4185 6.82597 14.8515 7.73824 14.8685 9.63602ZM12.9809 4.06197C13.5047 3.42791 13.8573 2.54524 13.7611 1.66699C13.006 1.69734 12.093 2.17013 11.5515 2.80384C11.0661 3.36502 10.641 4.26322 10.7557 5.12409C11.5973 5.1892 12.4571 4.69643 12.9809 4.06197Z"]],template:function(t,n){t&1&&(h(),N(0,"svg",0),g(1,"path",1),D())},encapsulation:2})};var O=class e{static \u0275fac=function(t){return new(t||e)};static \u0275cmp=p({type:e,selectors:[["app-google-widget"]],decls:5,vars:0,consts:[["xmlns","http://www.w3.org/2000/svg","width","21","height","20","viewBox","0 0 21 20","fill","none"],["d","M6.3243 11.5646L5.80218 13.5138L3.89381 13.5542C3.32349 12.4964 3 11.2861 3 9.99995C3 8.75627 3.30246 7.58346 3.83859 6.55078H3.839L5.53798 6.86226L6.28223 8.55105C6.12646 9.00517 6.04156 9.49267 6.04156 9.99995C6.04162 10.5505 6.14134 11.078 6.3243 11.5646Z","fill","#FBBB00"],["d","M17.8691 8.59863C17.9552 9.05232 18.0001 9.52087 18.0001 9.99972C18.0001 10.5367 17.9437 11.0604 17.8361 11.5657C17.471 13.2849 16.517 14.7861 15.1955 15.8485L15.1951 15.8481L13.0551 15.7389L12.7523 13.8482C13.6292 13.3339 14.3145 12.5291 14.6755 11.5657H10.665V8.59863H14.734H17.8691Z","fill","#518EF8"],["d","M15.1946 15.8481L15.195 15.8485C13.9097 16.8816 12.277 17.4997 10.4997 17.4997C7.64354 17.4997 5.16032 15.9033 3.89355 13.554L6.32404 11.5645C6.95741 13.2548 8.58804 14.4581 10.4997 14.4581C11.3214 14.4581 12.0912 14.236 12.7517 13.8482L15.1946 15.8481Z","fill","#28B446"],["d","M15.2865 4.22663L12.8568 6.21577C12.1732 5.78844 11.365 5.54159 10.4993 5.54159C8.54433 5.54159 6.8832 6.80009 6.28156 8.55107L3.8383 6.5508H3.83789C5.08611 4.14422 7.60065 2.5 10.4993 2.5C12.319 2.5 13.9876 3.14822 15.2865 4.22663Z","fill","#F14336"]],template:function(t,n){t&1&&(h(),N(0,"svg",0),g(1,"path",1)(2,"path",2)(3,"path",3)(4,"path",4),D())},encapsulation:2})};var ct=(e,i)=>[e,i],P=class e{className="";reverseTheme=!1;static \u0275fac=function(t){return new(t||e)};static \u0275cmp=p({type:e,selectors:[["logo-widget"]],inputs:{className:"className",reverseTheme:"reverseTheme"},decls:11,vars:4,consts:[["width","152","height","32","viewBox","0 0 152 32","fill","none","xmlns","http://www.w3.org/2000/svg",3,"ngClass"],["clip-path","url(#clip0_697_2374)"],["d","M9.49284 22.2426L15.4179 6.9315V0L5.17065 23.3063L9.49284 22.2426Z"],["d","M15.9999 8.65381L10.6243 22.5453L15.9999 26.7894L21.3756 22.5453L15.9999 8.65381ZM13.8527 18.8512L15.0306 18.004C15.656 17.5538 16.3358 18.4996 15.7105 18.9492L14.5327 19.7964C13.9144 20.2415 13.2245 19.303 13.8527 18.8512ZM18.4382 20.7471L14.9075 23.2866C14.2895 23.7315 13.599 22.7935 14.2276 22.3414L17.7582 19.8019C18.3839 19.3517 19.0631 20.2975 18.4382 20.7471Z"],["d","M15.4175 27.8132L9.78876 23.3691L5.47021 24.4319L15.4175 32.0003V27.8132Z"],["d","M22.2109 23.3691L16.582 27.8132V32.0003L26.5294 24.4319L22.2109 23.3691Z"],["d","M16.582 6.9315L22.5071 22.2426L26.8293 23.3062L16.582 0V6.9315Z"],["d","M47.584 6.96C53.008 6.96 56.056 10.032 56.056 15.504C56.056 20.952 53.08 24 47.728 24H41.92V6.96H47.584ZM45.04 21.288H47.584C51.136 21.288 52.864 19.392 52.864 15.504C52.864 11.568 51.136 9.672 47.584 9.672H45.04V21.288ZM58.0103 6.96H61.1303V24H58.0103V6.96ZM63.1233 24L69.2673 6.96H73.0833L79.2273 24H75.9633L74.5473 19.968H67.8033L66.3873 24H63.1233ZM68.7153 17.304H73.6353L71.1873 10.104L68.7153 17.304ZM80.8394 6.96H85.0394L89.7434 20.16L94.4234 6.96H98.6474V24H95.5274V12.288L91.2314 23.976H88.2554L83.9594 12.288V24H80.8394V6.96ZM109.264 24.384C104.2 24.384 101.128 21 101.128 15.504C101.128 9.96 104.2 6.576 109.264 6.576C114.352 6.576 117.376 9.96 117.376 15.504C117.376 21 114.352 24.384 109.264 24.384ZM104.392 15.504C104.392 19.344 106.192 21.672 109.264 21.672C112.336 21.672 114.16 19.344 114.16 15.504C114.16 11.616 112.336 9.288 109.264 9.288C106.192 9.288 104.392 11.616 104.392 15.504ZM119.559 6.96H123.207L130.455 19.608V6.96H133.599V24H129.831L122.679 11.688V24H119.559V6.96ZM142.321 6.96C147.745 6.96 150.793 10.032 150.793 15.504C150.793 20.952 147.817 24 142.465 24H136.657V6.96H142.321ZM139.777 21.288H142.321C145.873 21.288 147.601 19.392 147.601 15.504C147.601 11.568 145.873 9.672 142.321 9.672H139.777V21.288Z"],["id","clip0_697_2374"],["width","32","height","32"]],template:function(t,n){t&1&&(h(),r(0,"svg",0)(1,"g",1),a(2,"path",2)(3,"path",3)(4,"path",4)(5,"path",5)(6,"path",6),c(),a(7,"path",7),r(8,"defs")(9,"clipPath",8),a(10,"rect",9),c()()()),t&2&&s("ngClass",j(1,ct,n.className,n.reverseTheme?"fill-surface-0 dark:fill-surface-900":"fill-surface-900 dark:fill-surface-0"))},dependencies:[k,A],encapsulation:2})};var L=class{sUsuario;sPassword;constructor(i,t){this.sUsuario=i,this.sPassword=t}};var Y={production:!0,preurl:"",servicios:{api:"api de produccion/"}};var W=class e{constructor(i){this.http=i}login(i){return console.log("login en service",i),this.http.post(Y.servicios.api.concat("auth/login"),i)}refresh(i){return this.http.post(Y.servicios.api.concat("auth/refresh"),i)}static \u0275fac=function(t){return new(t||e)(ee(he))};static \u0275prov=I({token:e,factory:e.\u0275fac,providedIn:"root"})};var Oe=class e{constructor(i,t,n,o){this.fb=i;this.tokenService=t;this.authService=n;this.router=o;this.loginForm=this.fb.group({usuario:[""],password:[""],remember:[!1]}),this.loginUsuario=new L("","")}messageService=S(xe);loginUsuario;roles=[];loginForm;currentYear=new Date().getFullYear();onLogin(){this.loginUsuario=new L(this.usuario.value,this.password.value),this.authService.login(this.loginUsuario).subscribe({next:i=>{switch(this.tokenService.setToken(i.token),this.tokenService.getRoles().toString()){case"ADMINISTRADOR":this.router.navigate(["/inicio"]);break;case"COMUNICACION":this.router.navigate(["/comunicacion/infraestructura"]);break;default:this.router.navigate(["/superior/tablero"]);break}this.messageService.add({severity:"success",summary:"Acceso Correcto",detail:"Inicio de sesi\xF3n correcto",life:3e3})},error:i=>{this.messageService.add({severity:"error",summary:"Acceso Incorrecto",detail:"",life:3e3}),this.router.navigate([""])}})}get usuario(){return this.loginForm.get("usuario")}get password(){return this.loginForm.get("password")}static \u0275fac=function(t){return new(t||e)(w(Fe),w(Be),w(W),w(me))};static \u0275cmp=p({type:e,selectors:[["app-login"]],decls:43,vars:3,consts:[[1,"min-h-screen","flex","items-center","lg:items-start","lg:py-20","justify-center","animate-fadein","animate-duration-300","animate-ease-in","max-w-400","mx-auto"],[1,"flex","w-full","h-full","justify-center","gap-12"],[1,"flex","flex-col","py-20","lg:min-w-120"],["routerLink","/",1,"flex","items-center","justify-center","lg:justify-start","mb-8"],[1,"flex","flex-col","justify-center","grow"],[1,"max-w-md","mx-auto","w-full"],[1,"title-h5","text-center","lg:text-left"],[1,"body-small","mt-3.5","text-center","lg:text-left"],[1,"social-button","mt-8"],[1,"social-button","mt-4"],[1,"flex","items-center","gap-3.5","my-7"],[1,"flex-1","h-px","bg-surface-200","dark:bg-surface-800"],[1,"body-small","text-surface-400","dark:text-surface-600"],[3,"ngSubmit","formGroup"],["type","text","formControlName","usuario","pInputText","","placeholder","Usuario","required","",1,"w-full"],["type","password","formControlName","password","pInputText","","placeholder","Password","required","",1,"w-full","mt-4"],[1,"my-8","flex","items-center","justify-between"],[1,"flex","items-center","gap-2"],["inputId","remember","formControlName","remember",3,"binary"],["for","remember",1,"body-small"],["routerLink","/auth/forgot-password",1,"body-small","text-primary-500","hover:underline"],["type","submit","on","",1,"body-button","w-full"],[1,"mt-8","body-small","text-center","lg:text-left"],["routerLink","/auth/register",1,"text-primary-500","hover:underline"],[1,"mt-8","text-center","lg:text-start","block","relative","text-surface-400","dark:text-surface-500","text-sm"],[1,"hidden","lg:flex","h-full","py-20"],[1,"h-full","w-full","lg:max-w-130","xl:max-w-242","mx-auto","flex","items-center","justify-center","shadow-[0px_1px_2px_0px_rgba(18,18,23,0.05)]","rounded-3xl","border","border-surface","overflow-hidden"],["className","w-auto h-full object-contain object-left","src","/demo/images/landing/auth-image.svg","alt","Auth Image"]],template:function(t,n){t&1&&(r(0,"section",0)(1,"div",1)(2,"div",2)(3,"a",3),a(4,"logo-widget"),c(),r(5,"div",4)(6,"div",5)(7,"h5",6),u(8,"Login"),c(),r(9,"p",7),u(10,"Please enter your details"),c(),r(11,"button",8),a(12,"app-google-widget"),u(13," Sign in with Google"),c(),r(14,"button",9),a(15,"app-apple-widget"),u(16," Sign in with Apple"),c(),r(17,"div",10),a(18,"span",11),r(19,"span",12),u(20,"or"),c(),a(21,"span",11),c(),r(22,"form",13),H("ngSubmit",function(){return n.onLogin()}),a(23,"input",14)(24,"input",15),r(25,"div",16)(26,"div",17),a(27,"p-checkbox",18),r(28,"label",19),u(29,"Remember me"),c()(),r(30,"a",20),u(31,"Forgot password?"),c()(),r(32,"button",21),u(33,"Login"),c()(),r(34,"div",22),u(35,"Not registered? "),r(36,"a",23),u(37,"Create an Account"),c()()()(),r(38,"div",24),u(39),c()(),r(40,"div",25)(41,"div",26),a(42,"app-lazy-image-widget",27),c()()()()),t&2&&(d(22),s("formGroup",n.loginForm),d(5),s("binary",!0),d(12),ae("\xA9",n.currentYear," PrimeTek"))},dependencies:[P,k,Te,Le,ye,_e,Me,Ve,Ie,Se,Ne,Ee,je,O,R,Re,G,be],encapsulation:2})};export{Oe as Login};
